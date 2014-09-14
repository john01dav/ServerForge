package src.john01dav.serverforge.loader;
import com.google.common.io.Files;
import src.john01dav.serverforge.ServerForge;
import src.john01dav.serverforge.api.ServerForgePlugin;
import src.john01dav.serverforge.plugin.ServerForgeDefaultPlugin;

import java.io.File;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;

public class PluginLoader{
    private ArrayList<PluginFile> pluginFile;
    private ArrayList<PluginWrapper> pluginWrapper;
    private URLClassLoader loader;
    private File pluginsFolder;

    public void onServerStart(){
        pluginsFolder = new File("./plugins");

        try {
            if (!pluginsFolder.isDirectory()) {
                Files.move(pluginsFolder, new File("./plugins-file"));
                pluginsFolder.delete();
            }

            if (!pluginsFolder.exists()) {
                pluginsFolder.mkdir();
            }
        }catch(IOException e){
            e.printStackTrace();
            System.exit(0);
        }

        pluginFile = new ArrayList<PluginFile>();
        pluginWrapper = new ArrayList<PluginWrapper>();
        ArrayList<URL> pluginURL = new ArrayList<URL>();

        ServerForge.info("Loading plugins...");
        for(File file : pluginsFolder.listFiles()){
            ServerForge.info("Loading " + file.getAbsolutePath());
            if(file.getName().endsWith(".jar") || (!file.isDirectory())){
                PluginFile pFile = new PluginFile(file);

                if(pFile.getName() == null) {
                    ServerForge.error("Plugin " + file.getAbsolutePath() + " does not have a name set, please add the name to plugindata.txt");
                }else if(pFile.getMainClass() == null){
                    ServerForge.error("Plugin " + file.getAbsolutePath() + " does not have a mainClass set, please add the name to plugindata.txt");
                }else{
                    pluginFile.add(pFile);
                    pluginURL.add(pFile.getURL());
                    ServerForge.info("Loaded " + pFile.getName());
                }
            }else{
                ServerForge.info("Skipping " + file.getAbsolutePath() + " not a plugin.");
            }
        }
        ServerForge.info("Plugins loaded");

        loader = new URLClassLoader(pluginURL.toArray(new URL[pluginURL.size()]), getClass().getClassLoader());

        ServerForge.info("Starting plugins");
        for(PluginFile pFile : pluginFile){
            try {
                startPlugin(pFile, loader);
            }catch(ClassNotFoundException e){
                ServerForge.error("Failed to load plugin " + pFile.getName() + ". Can not load main class " + pFile.getMainClass() + ".");
                e.printStackTrace();
            }catch(InstantiationException e){
                ServerForge.error("Failed to load plugin " + pFile.getName() + ". Can not instantiate main class " + pFile.getMainClass() + ". (" + e.getClass().getCanonicalName() + ")");
                e.printStackTrace();
            }catch(IllegalAccessException e){
                ServerForge.error("Failed to load plugin " + pFile.getName() + ". Can not instantiate main class " + pFile.getMainClass() + ". (" + e.getClass().getCanonicalName() + ")");
                e.printStackTrace();
            }catch(ClassCastException e){
                ServerForge.error("Failed to load plugin " + pFile.getName() + ". Can not instantiate main class is not instanceof " + ServerForgePlugin.class.getCanonicalName() + ".");
                e.printStackTrace();
            }catch(NullPointerException e){
                ServerForge.error("Failed to load plugin " + pFile.getName() + ". Could not load main class " + ServerForgePlugin.class.getCanonicalName() + ". (nullpointerexception)");
                e.printStackTrace();
            }
        }

        ServerForge.info("Starting ServerForgePlugin");
        ServerForgeDefaultPlugin plugin = new ServerForgeDefaultPlugin();

        PluginWrapper wrapper = new PluginWrapper(plugin, "ServerForgePlugin");
        pluginWrapper.add(wrapper);

        plugin.onServerStart();

        ServerForge.info("ServerForgePlugin started");
    }

    private void startPlugin(PluginFile pFile, ClassLoader loader) throws ClassNotFoundException, InstantiationException, IllegalAccessException, ClassCastException, NullPointerException{
        ServerForge.info("Starting " + pFile.getName());
        String mainClass = pFile.getMainClass();

        if(loader == null){
            System.out.println("Classloader null?!");
        }

        Class<?> pluginClass = loader.loadClass(mainClass);
        Object instance = pluginClass.newInstance();
        ServerForgePlugin plugin = ((ServerForgePlugin) instance);
        PluginWrapper wrapper = new PluginWrapper(plugin, pFile.getName());
        pluginWrapper.add(wrapper);

        plugin.onServerStart();

        ServerForge.info(pFile.getName() + " started");
    }

    /**
     * Returns a list of all plugins in their wrappers
     * @return A list of all plugins in their wrappers
     */
    public ArrayList<PluginWrapper> getPlugins(){
        return pluginWrapper;
    }

    public File getPluginsFolder(){
        return pluginsFolder;
    }

}
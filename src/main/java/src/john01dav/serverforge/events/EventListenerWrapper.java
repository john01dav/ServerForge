package src.john01dav.serverforge.events;
import src.john01dav.serverforge.ServerForge;
import java.lang.reflect.Method;

public class EventListenerWrapper{
    private EventListener listener;

    protected EventListenerWrapper(EventListener listener){
        this.listener = listener;
    }

    protected void callEvent(Object event){
        for(Method method : listener.getClass().getMethods()){
            try {
                Class<?>[] parameterTypes = method.getParameterTypes();

                if (parameterTypes.length == 1) {
                    Class<?> parameter = parameterTypes[0];

                    if (parameter.getCanonicalName().equalsIgnoreCase(event.getClass().getCanonicalName())) {
                        method.setAccessible(true);
                        method.invoke(listener, new Object[]{event});
                    }

                }
            }catch(Exception e){
                ServerForge.instance.error("Failed to invote listener: " + e.getMessage());
                e.printStackTrace();;
            }
        }
    }

}

package spring.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

import com.GsonUtil;

public class MethodExecutionEventListener implements ApplicationListener {  
  
    public void onApplicationEvent(ApplicationEvent event) {  
        if (event instanceof MethodExecutionEvent) {  
           if (MethodExecutionStatus.BEGIN  
                    .equals(((MethodExecutionEvent) event)  
                            .getMethodExecutionStatus())) {  
        	   	System.out.println("BEGIN");
                System.out.println(GsonUtil.parseJsonObject(event));
            }  
            if (MethodExecutionStatus.END.equals(((MethodExecutionEvent) event).getMethodExecutionStatus())) { 
            	System.out.println("END");
            	System.out.println(GsonUtil.parseJsonObject(event));
            }  
        }  
    }  
}  
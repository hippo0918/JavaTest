package spring.listener;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class MethodExecutionEventPublisher implements  
        ApplicationEventPublisherAware {  
  
    private ApplicationEventPublisher eventPublisher;  
      
    public void methodToMonitor() {  
        MethodExecutionEvent beginEvent = new MethodExecutionEvent(this, "methodToMonitor", MethodExecutionStatus.BEGIN);  
        this.eventPublisher.publishEvent(beginEvent);  
        //TODO  
        MethodExecutionEvent endEvent = new MethodExecutionEvent(this, "methodToMonitor", MethodExecutionStatus.END);  
        this.eventPublisher.publishEvent(endEvent);  
    }  
      
    public void setApplicationEventPublisher(  
            ApplicationEventPublisher applicationEventPublisher) {  
        this.eventPublisher = applicationEventPublisher;  
    }  
}  
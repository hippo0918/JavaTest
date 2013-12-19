package spring.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App   
{  
    public static void main(String[] args)  
    {  
        ApplicationContext context = new ClassPathXmlApplicationContext("com\\talent\\yjtorgfep\\core\\listener\\spring-listener.xml");  
        MethodExecutionEventPublisher publisher = (MethodExecutionEventPublisher)context.getBean("evtPublisher");  
        publisher.methodToMonitor();  
    }  
}  
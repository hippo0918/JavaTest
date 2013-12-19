package spring.listener;  
  
import org.springframework.context.ApplicationEvent;
/** 
 * 定义Spring容器中的事件，与java普通的事件定义相比，只是继承的父类不同而已，在 
 * 在定义上并未有太大的区别，毕竟ApplicationEvent也是继承自EventObject的。 
 */  
public class MethodExecutionEvent extends ApplicationEvent {  
  
    private static final long serialVersionUID = 2565706247851725694L;  
    private String methodName;  
    private MethodExecutionStatus methodExecutionStatus;  
      
    public MethodExecutionEvent(Object source) {  
        super(source);  
    }  
      
    public MethodExecutionEvent(Object source, String methodName, MethodExecutionStatus methodExecutionStatus) {  
        super(source);  
        this.methodName = methodName;  
        this.methodExecutionStatus = methodExecutionStatus;  
    }  
  
    public String getMethodName() {  
        return methodName;  
    }  
  
    public void setMethodName(String methodName) {  
        this.methodName = methodName;  
    }  
  
    public MethodExecutionStatus getMethodExecutionStatus() {  
        return methodExecutionStatus;  
    }  
  
    public void setMethodExecutionStatus(MethodExecutionStatus methodExecutionStatus) {  
        this.methodExecutionStatus = methodExecutionStatus;  
    }  
}  
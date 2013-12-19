package spring.listener;  
  
import org.springframework.context.ApplicationEvent;
/** 
 * ����Spring�����е��¼�����java��ͨ���¼�������ȣ�ֻ�Ǽ̳еĸ��಻ͬ���ѣ��� 
 * �ڶ����ϲ�δ��̫������𣬱Ͼ�ApplicationEventҲ�Ǽ̳���EventObject�ġ� 
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
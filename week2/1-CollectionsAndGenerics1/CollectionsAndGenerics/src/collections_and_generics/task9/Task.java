package collections_and_generics.task9;

public class Task {
	private int priority;
	private float timeRequired;
	private boolean finished;
	private boolean cancelled;
	private String status;
	private String taskName;
	
	public Task(String taskName, int priority, float timeRequired) {
		setPriority(priority);
		setTimeRequired(timeRequired);
		this.finished = false;
		this.cancelled = false;
		this.taskName = taskName;
	}
	
	private void setPriority(int priority) {
		if (priority < 0 || priority > 10)
			throw new IllegalArgumentException("Priority [1 - 10]!!!");
		this.priority = priority;
	}
	
	private void setTimeRequired(float timeRequired) {
		if(timeRequired < 0) 
			throw new IllegalArgumentException("Time has to be more than 0 !!!");
		this.timeRequired = timeRequired;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public float getTimeRequired() {
		return timeRequired;
	}
	
	public void isFinished() {
		this.finished = true;
	}
	
	public void isCancelled() {
		this.cancelled = true;
	}
	
	private String getStatus() {
		if (finished && !cancelled) {
			return status = "finished";
		} else if (!finished && !cancelled)
			return status = "active";
		else 
			return status = "cancelled";
	}
	
	public boolean getStatusTask() {
		if (finished) {
			return true;
		} else if (cancelled)
			return true;
		else 
			return false;
	}
	
	@Override
	public String toString() {
		return "Priority: " + this.taskName + ", Time Required: " + getTimeRequired() + ", Status: " + getStatus();
	}
}

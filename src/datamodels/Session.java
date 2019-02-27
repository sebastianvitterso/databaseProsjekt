package datamodels;

import java.sql.Date;
import java.sql.Timestamp;

public class Session {
	private final int session_id;
	private Date date;
	private Timestamp timeStamp;
	private int duration; // minutes
	private int shape;
	private int performance;
	
	public Session(int session_id, Date date, Timestamp timeStamp, int duration, int shape, int performance) {
		this.session_id = session_id;
		this.date = date;
		this.timeStamp = timeStamp;
		this.duration = duration;
		this.shape = shape;
		this.performance = performance;
	}
	
	public int getSession_id() {
		return session_id;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Timestamp getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getShape() {
		return shape;
	}

	public void setShape(int shape) {
		this.shape = shape;
	}

	public int getPerformance() {
		return performance;
	}

	public void setPerformance(int performance) {
		this.performance = performance;
	}
}

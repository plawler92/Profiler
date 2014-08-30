import java.sql.Time;

//take StartMessage timer message

public class Timer{

  Time t;
  long start;
  long stop;
  String start_message;
  String stop_message;
  boolean running;


  public Timer(){
    setStart();
    running = true;
    start_message = "";
    stop_message = "";
  }
  public Timer(String message){
    setStart();
    setStartMessage(message);
    running = true;
    stop_message = null;
  }
  public String toString(){
    return "Time taken: " + String.valueOf(stop - start) + "\nStart Message: " + start_message + "\nStop Message: " + stop_message;
  }
  public void  setStart(){
    start = System.currentTimeMillis();
  }
  public void setStart(String message){
    start = System.currentTimeMillis();
    setStartMessage(message);
  }
  public void  setStop(){
    stop = System.currentTimeMillis();
    running = false;
  }
  public void setStop(String message){
    stop = System.currentTimeMillis();
    setStopMessage(message);
    running = false;
  }
  public long getStart(){
    return start;
  }
  public long getStop(){
    return stop;
  }
  public long getTimed(){
    return stop-start;
  }
  public void setStartMessage(String message){
    start_message = message;
  }
  public String getStartMessage(){
    return start_message;
  }
  public void setStopMessage(String message){
    stop_message = message;
  }
  public String getStopMessage(){
    return stop_message;
  }
  public boolean getRunning(){
    return running;
  }

}

public class Driver{
  public static void main(String args[]){

    //program is adding correct number of timers

    Profiler.getInstance().start("test", "1");
    Profiler.getInstance().start("test", "2");

    for(int i = 0; i < 100000; i++){

    }

    Profiler.getInstance().stop("test", "2");
    Profiler.getInstance().stop("test", "1");



    for(int i = 0; i < 10; i++){
        Profiler.getInstance().start("Test Timer", "Iteration: " + i);

    }
    for(int i = 9; i >= 0; i--){
        Profiler.getInstance().stop("Test Timer","Iteration: " + i);
    }

    Profiler.getInstance().start("HEY", "1");
    Profiler.getInstance().start("HEY", "2");

    for(int i = 0; i < 100000; i++){

    }

    Profiler.getInstance().stop("HEY", "2");
    Profiler.getInstance().stop("HEY", "1");
    Profiler.getInstance().generateReport();





  }
}

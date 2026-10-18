public class Timer {

    private long start;
    private long end;

    //Starts the time measurement
    public void begin() {
        start = System.nanoTime();
    }

    //Stops the time measurement
    public void finish() {
        end = System.nanoTime();
    }

    //Returns the elapsed time in nanoseconds
    public long getNanoTime() {
        return end - start;
    }

    //Return the elapsed time in milliseconds
    public long getMicroTime() {
        return (end - start) / 1000;
    }

    //Returns the elapsed time in milliseconds
    public long getMilliTime() {
        return (end - start) / 1_000_000;
    }
}





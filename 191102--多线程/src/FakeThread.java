public class FakeThread {
    private boolean interruptStatus = false;

    public void interrupt() {
        if (/* 对象的关联线程正在 sleep */ true) {
            interruptStatus = false;
            // throw new InterruptedException() 给该线程;
        }

        interruptStatus = true;
    }

    public boolean isInterrupted() {
        return interruptStatus;
    }

    public static boolean interrupted() {
        //boolean status = currentThread().interruptedStatus;
        //currrentThread().interruptedStatus = false;
        //return status;

        return false;
    }
}

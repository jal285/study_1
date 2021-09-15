package javaconcurrent.CountDownLatch;

import java.util.concurrent.CountDownLatch;

public abstract class BaseHealthChecker implements  Runnable{


    private CountDownLatch _latch;
    private String _serviceName;
    private boolean _serviceUp;

    //Get latch object in constructor so that after completing the task ,thread can countDown() the latch
    public BaseHealthChecker(String _serviceName,CountDownLatch latch){
        super();
        this._latch = latch;
        this._serviceName = _serviceName;
        this._serviceUp = false;
    }

    @Override
    public void run() {
        try {
            verfityService();
            _serviceUp = true;
        } catch (Exception e) {
            e.printStackTrace(System.err);
            _serviceUp = false;
        }finally {
            if(_latch!=null){
                _latch.countDown();
            }
        }
    }




    public String get_serviceName() {
        return _serviceName;
    }

    public boolean isServiceUp() {
        return _serviceUp;
    }

    public abstract void verfityService();

}

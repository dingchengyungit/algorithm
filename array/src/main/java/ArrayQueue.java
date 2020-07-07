/**
 * @author dingchengyun
 * @date 2020/7/6
 * @description
 */
public class ArrayQueue {

    int size = 0;
    int head = 0;
    int tail = 0;

    Object[] objQueue = new Object[10];

    public Object pop(){
        if (size > 0) {
            head++;
            size--;
//            objQueue[head] = null;
            return objQueue[head];
        }

        return null;
    }

    public void push(Object obj) {
        if (size < 10) {
            objQueue[tail] = obj;
            tail++;
            size++;
        } else {
            //
        }
    }
}

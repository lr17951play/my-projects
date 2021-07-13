package com.lirui.demo.model.action.chain;

/**
 * 在这里结合了模板模式，处理链由模板定义，处理器无需关注上下游。只要专注自己的处理业务即可
 * @author Ryan
 */
public abstract class Handler {

    protected Handler next;

    public Handler next(Handler next){
        return this.next = next;
    }

    public void handle(int target){
        if (resolve(target)){
            finish();
        } else if (next != null) {
            next.handle(target);
        } else {
            fail();
        }
    }

    private void finish() {
        System.out.println("符合条件，处理完成...");
    }

    private void fail() {
        System.out.println("未找到合适的处理器，无法处理...");
    }

    /** 处理链 */
    protected abstract boolean resolve(int target);
}

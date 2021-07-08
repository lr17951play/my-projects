package com.lirui.demo.model.action.command;

import lombok.NoArgsConstructor;

/**
 * @author Ryan
 */
@NoArgsConstructor
public class NoodlesChef{

    public void cookBeefNoodles(int num) {
        System.out.println("Order successfully: NoodlesChef is cooking beef noodles... totally: " + num);
    }

    public void cookChickenNoodles(int num) {
        System.out.println("Order successfully: NoodlesChef is cooking chicken noodles... totally: " + num);
    }
}

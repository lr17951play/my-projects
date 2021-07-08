package com.lirui.demo.model.action.command;

import lombok.NoArgsConstructor;

/**
 * @author Ryan
 */
@NoArgsConstructor
public class CakeChef{

    public void cookCake(int num) {
        System.out.println("Order successfully: CakeChef is cooking cake... totally: " + num);
    }
}

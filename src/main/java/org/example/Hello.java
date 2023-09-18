package org.example;

import static java.lang.Thread.sleep;

public class Hello {
    public Hello() {
        showLogo();
        sleep();
        showSber();
        sleep();
    }

    private void showLogo() {
        String[] logo = {
                "                                           *****                                     ",
                "                                  ***                                                ",
                "                             **                          #                           ",
                "                          *                            #                             ",
                "                        *                            #             *                  ",
                "                      *           #                #                 *                ",
                "                    *                #           #                    *               ",
                "                   *                    #      #                       *              ",
                "                   *                         *                         *              ",
                "                   *                                                   *              ",
                "                    *                                                 *               ",
                "                     *                                               *                ",
                "                       *                                            *                 ",
                "                         *                                       *                    ",
                "                             **                              **                       ",
                "                                  ***                 ***                             ",
                "                                           *****                                      "
        };
        for (String line : logo) {
            System.out.println(line);
        }
    }

    private void showSber() {
        String[] sber = {
                "                           *****    *****    *****   ******                 ",
                "                          *         *    *   *       *     *                ",
                "                          *         *    *   *       *     *                ",
                "                           ****     *****    *****   *****                  ",
                "                               *    *    *   *       *     *                ",
                "                          *    *    *    *   *       *       *              ",
                "                           *****    *****    *****   *       *              "
        };
        for (String line : sber) {
            System.out.println(line);
        }
    }

    private void sleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

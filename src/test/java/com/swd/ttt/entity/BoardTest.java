package com.swd.ttt.entity;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

@RunWith(SpringRunner.class)
public class BoardTest {

    private static Board board;

    @BeforeClass
    public static void setUp() {
        board = new Board();
        System.out.println("--> " + board.getTttBoards()[0]);
    }

}

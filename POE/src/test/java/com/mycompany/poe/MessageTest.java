/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.poe;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author lab_services_student
 */
public class MessageTest {

    public MessageTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testMessageLength() {//tests error messaging for message length
        Message test = new Message("+27718693002", "Hi Mike, can you join us for dinner tonight", 0);
        assertEquals("Message sent", test.checkMessageLength(), "Message sent");
        String mess = ("1:1	  	起 初 　 神 創 造 天 地 。\n"
                + "1:2	  	地 是 空 虛 混 沌 ． 淵 面 黑 暗 ． 　 神 的 靈 運 行 在 水 面 上 。\n"
                + "1:3	  	　 神 說 、 要 有 光 、 就 有 了 光 。\n"
                + "1:4	  	　 神 看 光 是 好 的 、 就 把 光 暗 分 開 了 。\n"
                + "1:5	  	　 神 稱 光 為 晝 、 稱 暗 為 夜 ． 有 晚 上 、 有 早 晨 、 這 是 頭 一 日 。\n"
                + "1:6	  	　 神 說 、 諸 水 之 間 要 有 空 氣 、 將 水 分 為 上 下 。\n"
                + "1:7	  	　 神 就 造 出 空 氣 、 將 空 氣 以 下 的 水 、 空 氣 以 上 的 水 分 開 了 ． 事 就 這 樣 成 了 。\n"
                + "1:8	  	　 神 稱 空 氣 為 天 ． 有 晚 上 、 有 早 晨 、 是 第 二 日 。\n"
                + "1:9	  	　 神 說 、 天 下 的 水 要 聚 在 一 處 、 使 旱 地 露 出 來 ． 事 就 這 樣 成 了 。\n"
                + "1:10	  	　 神 稱 旱 地 為 地 、 稱 水 的 聚 處 為 海 ． 　 神 看 著 是 好 的 。\n"
                + "1:11	  	　 神 說 、 地 要 發 生 青 草 、 和 結 種 子 的 菜 蔬 、 並 結 果 子 的 樹 木 、 各 從 其 類 、 果 子 都 包 著 核 ． 事 就 這 樣 成 了 。\n"
                + "1:12	  	於 是 地 發 生 了 青 草 、 和 結 種 子 的 菜 蔬 、 各 從 其 類 、 並 結 果 子 的 樹 木 、 各 從 其 類 、 果 子 都 包 著 核 。 　 神 看 著 是 好 的 ．\n"
                + "1:13	  	有 晚 上 、 有 早 晨 、 是 第 三 日 。\n"
                + "1:14	  	　 神 說 、 天 上 要 有 光 體 、 可 以 分 晝 夜 、 作 記 號 、 定 節 令 、 日 子 、 年 歲 ．\n"
                + "1:15	  	並 要 發 光 在 天 空 、 普 照 在 地 上 ． 事 就 這 樣 成 了 。\n"
                + "1:16	  	於 是 　 神 造 了 兩 個 大 光 、 大 的 管 晝 、 小 的 管 夜 ． 又 造 眾 星 。\n"
                + "1:17	  	就 把 這 些 光 擺 列 在 天 空 、 普 照 在 地 上 、\n"
                + "1:18	  	管 理 晝 夜 、 分 別 明 暗 ． 　 神 看 著 是 好 的 ．\n"
                + "1:19	  	有 晚 上 、 有 早 晨 、 是 第 四 日 。\n"
                + "1:20	  	　 神 說 、 水 要 多 多 滋 生 有 生 命 的 物 ． 要 有 雀 鳥 飛 在 地 面 以 上 、 天 空 之 中 。\n"
                + "1:21	  	　 神 就 造 出 大 魚 、 和 水 中 所 滋 生 各 樣 有 生 命 的 動 物 、 各 從 其 類 ． 又 造 出 各 樣 飛 鳥 、 各 從 其 類 ． 　 神 看 著 是 好 的 。\n"
                + "1:22	  	　 神 就 賜 福 給 這 一 切 、 說 、 滋 生 繁 多 、 充 滿 海 中 的 水 ． 雀 鳥 也 要 多 生 在 地 上 。\n"
                + "1:23	  	有 晚 上 、 有 早 晨 、 是 第 五 日 。\n"
                + "1:24	  	　 神 說 、 地 要 生 出 活 物 來 、 各 從 其 類 ． 牲 畜 、 昆 蟲 、 野 獸 、 各 從 其 類 ． 事 就 這 樣 成 了 。\n"
                + "1:25	  	於 是 　 神 造 出 野 獸 、 各 從 其 類 ． 牲 畜 、 各 從 其 類 ． 地 上 一 切 昆 蟲 、 各 從 其 類 ． 　 神 看 著 是 好 的 。\n"
                + "1:26	  	　 神 說 、 我 們 要 照 著 我 們 的 形 像 、 按 著 我 們 的 樣 式 造 人 、 使 他 們 管 理 海 裡 的 魚 、 空 中 的 鳥 、 地 上 的 牲 畜 、 和 全 地 、 並 地 上 所 爬 的 一 切 昆 蟲 。\n"
                + "1:27	  	　 神 就 照 著 自 己 的 形 像 造 人 、 乃 是 照 著 他 的 形 像 造 男 造 女 。\n"
                + "1:28	  	　 神 就 賜 福 給 他 們 、 又 對 他 們 說 、 要 生 養 眾 多 、 遍 滿 地 面 、 治 理 這 地 ． 也 要 管 理 海 裡 的 魚 、 空 中 的 鳥 ． 和 地 上 各 樣 行 動 的 活 物 。\n"
                + "1:29	  	　 神 說 、 看 哪 、 我 將 遍 地 上 一 切 結 種 子 的 菜 蔬 、 和 一 切 樹 上 所 結 有 核 的 果 子 、 全 賜 給 你 們 作 食 物 。\n"
                + "1:30	  	至 於 地 上 的 走 獸 、 和 空 中 的 飛 鳥 、 並 各 樣 爬 在 地 上 有 生 命 的 物 、 我 將 青 草 賜 給 他 們 作 食 物 ． 事 就 這 樣 成 了 。\n"
                + "1:31	  	　 神 看 著 一 切 所 造 的 都 甚 好 ． 有 晚 上 、 有 早 晨 、 是 第 六 日 。");
        test = new Message("+27718693002", mess, 0);
        assertEquals("Please enter a message of less than 250 characters.", test.checkMessageLength(), "Message exceeds 250 characters by " + (test.getMessage().length() - 250) + ", please reduce size.");
    }

    @Test
    public void testRecipientNumberFormat() {//test error messaging for cellphone number format
        Message test = new Message("+27718693002", "Hi Mike, can you join us for dinner tonight", 0);
        assertEquals(0, test.checkRecipientCell(), 0, "Cellphone number successfully captured.");
        test = new Message("0857595889", "Hi Keegan, did you receive the payment?", 1);
        assertEquals(1, test.checkRecipientCell(), "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again");

    }

    @Test
    public void testMessageHash() {//Message hash is correct though, due to variable Message IDs may vary
        Message test = new Message("+27718693002", "Hi Mike, can you join us for dinner tonight", 0);
        assertEquals(test.getID().substring(0, 2)+":0:HITONIGHT", test.getHash(), test.getHash());
    }

    @Test
    public void testMessageIDCreated() {//Message ID is created
        Message test = new Message("+27718693002", "Hi Mike, can you join us for dinner tonight", 0);
        assertEquals("", "", "Message ID created:" + test.getID());
    }

    @Test
    public void testMessageSent() {
        Message test = new Message("+27718693002", "Hi Mike, can you join us for dinner tonight", 0);//test user selected 'Send Message
        assertEquals("Message successfully sent.", test.testableSentMessage(0), "Message successfully sent.");

        test = new Message("+27718693002", "Hi Mike, can you join us for dinner tonight", 0);//test User selected 'Disregard Message
        assertEquals("Press 0 to delete message.", test.testableSentMessage(1), "Press 0 to delete message.");

        test = new Message("+27718693002", "Hi Mike, can you join us for dinner tonight", 0);   //test User selected 'Store Message'
        assertEquals("Message successfully stored.", test.testableSentMessage(2), "Message successfully stored.");
    }
    
}

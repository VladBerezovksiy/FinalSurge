package finalsurge.utils;

import io.qameta.allure.Attachment;

public class AllureUtils {

    @Attachment(value = "Failure screen", type = "image/png")
    public static byte[] attachScreenshot(byte[] bytes) {
        return bytes;
    }

    @Attachment(type = "text/json")
    public static byte[] attachJson(byte[] bytes) {
        return bytes;
    }
}
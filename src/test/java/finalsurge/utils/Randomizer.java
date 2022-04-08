package finalsurge.utils;

import org.bouncycastle.asn1.cms.TimeStampedData;


import java.sql.Timestamp;
import java.util.Date;

public class Randomizer {
    public static    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
public static long timeData = timestamp.getTime();
}

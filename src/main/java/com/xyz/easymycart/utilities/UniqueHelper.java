package com.xyz.easymycart.utilities;


import java.util.UUID;

public class UniqueHelper {

   public static String getSessionId() {
        return getId("SESN");
    }

   private static String getId(String prefix){
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();
        // Regex
        return prefix + uuidAsString;
    }
}

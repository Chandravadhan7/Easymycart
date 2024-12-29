package com.xyz.easymycart.utilities;

import java.time.Instant;

public class UtilityHelper {

  public static Long getCurrentMillis() {
    return Instant.now().toEpochMilli();
  }
}

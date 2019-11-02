package org.seedstack.seed.security;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seedstack.seed.testing.junit4.SeedITRunner;

@RunWith(SeedITRunner.class)
public class SecurityCredentialForgetterIT {

  @Test
  @WithUser(id = "cat", password = "alive")
  public void testShrodingerAlive() throws Exception {

  }

  @Test
  @WithUser(id = "cat", password = "dead")
  public void testShrodingerDead() throws Exception {
  }

}

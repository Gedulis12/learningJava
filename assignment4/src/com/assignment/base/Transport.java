package com.assignment.base;

public interface Transport {

   String getType();

   void setMotor(boolean motor);

   boolean getMotor();
   void setManufacturedYear(int year);

   int getManufacturedYear();
}

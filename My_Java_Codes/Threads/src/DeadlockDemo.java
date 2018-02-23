// DeadlockDemo.java
class DeadlockDemo
{
   public static void main (String [] args)
   {
      FinTrans6 ft = new FinTrans6 ();
      TransThread6 tt1 = new TransThread6 (ft, "Deposit Thread");
      TransThread6 tt2 = new TransThread6 (ft, "Withdrawal Thread");
      tt1.start ();
      tt2.start ();
   }
}
class FinTrans6
{
   public static String transName;
   public static double amount;
}
class TransThread6 extends Thread
{
   private FinTrans6 ft;
   private static String anotherSharedLock = "";
   TransThread6 (FinTrans6 ft, String name)
   {
      super (name); // Save thread's name
      this.ft = ft; // Save reference to financial transaction object
   }
   public void run ()
   {
      for (int i = 0; i < 6; i++)
      {
           if (getName ().equals ("Deposit Thread"))
           {
               synchronized (ft)
               {
                  synchronized (anotherSharedLock)
                  {
                     ft.transName = "Deposit";
                     try
                     {
                        Thread.sleep ((int) (Math.random () * 1000));
                     }
                     catch (InterruptedException e)
                     {
                     }
                     ft.amount = 2000.0;
                     System.out.println (ft.transName + " " + ft.amount);
                  }
               }
           }
           else
           {
               synchronized (anotherSharedLock)
               {
                  synchronized (ft)
                  {
                     ft.transName = "Withdrawal";
                     try
                     {
                        Thread.sleep ((int) (Math.random () * 1000));
                     }
                     catch (InterruptedException e)
                     {
                     }
                     ft.amount = 250.0;
                     System.out.println (ft.transName + " " + ft.amount);
                  }
               }
           }
      }
   }
}
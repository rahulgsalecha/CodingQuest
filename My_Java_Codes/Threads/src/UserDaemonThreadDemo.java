// UserDaemonThreadDemo.java
class UserDaemonThreadDemo
{
   public static void main (String [] args)
   {
      if (args.length == 0)
         new MyThread4 ().start ();
      else
      {
         MyThread4 mt = new MyThread4 ();
         mt.setDaemon (true);
         mt.start ();
      }
      try
      {
         Thread.sleep (100);
      }
      catch (InterruptedException e)
      {
      }
   }
}
class MyThread4 extends Thread
{
   public void run ()
   {
      System.out.println ("Daemon is " + isDaemon ());
      while (true);
   }
}


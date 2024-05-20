class P_break {
    public static void main(String[] args) {
        ext :
          for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
              if (i * j > 50) { 
                break ext;
            }
              System.out.print((i * j) + "/");
            }
          }
      }
}
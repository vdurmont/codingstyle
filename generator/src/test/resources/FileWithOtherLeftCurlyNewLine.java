public class FileWithOtherLeftCurlyNewLine {
    private final String test;

    public FileWithOtherLeftCurlyNewLine(String test) {
        this.test = test;
        if ("test".equals(test))
        {
            for (int i = 0; i < 10; i++)
            {
                System.out.println("Test!");
            }
        }
        else
        {
            int i = 0;
            while (i<test.length())
            {
                System.out.println("Not test!");
            }
        }
    }
}
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/*
 * This program is in the folder C:/hotel_reservation_submission which actually contains another
 * project by itself.
 * This program produces an output testX.html which is also
 * in the same folder C:/hotel_reservation_submission
 * These two programs should not be mixed with other stuff!
 */

public class html_java_example {

    public static void main(String[] args) {
        String html = "<!DOCTYPE html>\r\n" + //
                "<html lang=\"en\">\r\n" + //
                "<head>\r\n" + //
                "    <link rel=\"stylesheet\" href=\"Indrapalum.css\">\r\n" + //
                "    <meta charset=\"UTF-8\">\r\n" + //
                "    <meta name=\"discription\" content=\"Indrapalum company\">\r\n" + //
                "    <meta name=\"keywords\" content=\"Indrapalum\">\r\n" + //
                "    <meta name=\"author\" content=\"amrith\">\r\n" + //
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + //
                "    <title>Indrapalum company</title>\r\n" + //
                "</head>\r\n" + //
                "<body>\r\n" + //
                "  <div class=\"Indrapalum\">\r\n" + //
                "   <h1>about Indrapalum</h1>\r\n" + //
                "   <p>Indrapalum is a company who's founder is walnut</p>\r\n" + //
                "   <p>here are the forms for the hotels</p>\r\n" + //
                "   <iframe src=\"https://docs.google.com/forms/d/e/1FAIpQLSe4pE9pfL00gHpd7tueN3M_Pcp1xmFjBUy1AiqmRKPe93rmjg/viewform?embedded=true\" width=\"640\" height=\"1225\" frameborder=\"0\" marginheight=\"0\" marginwidth=\"0\">Loading…</iframe>\r\n"
                + //
                "   <iframe src=\"https://docs.google.com/forms/d/e/1FAIpQLSfERxMmGWpQVkogVVvOsy1YqpTDE0x_q1ZSK_7kJjeOEl2zkA/viewform?embedded=true\" width=\"640\" height=\"1225\" frameborder=\"0\" marginheight=\"0\" marginwidth=\"0\">Loading…</iframe>\r\n"
                + //
                "   <iframe src=\"https://docs.google.com/forms/d/e/1FAIpQLSfUZwBw1IB14-Sfe_t5FO_uCfYGn8Q8sdfclxHywfWKtvGRmA/viewform?embedded=true\" width=\"640\" height=\"1225\" frameborder=\"0\" marginheight=\"0\" marginwidth=\"0\">Loading…</iframe>\r\n"
                + //
                "   <p>if you wanna work for Indrapalum click this link</p>\r\n" + //
                "   <a href=\"https://forms.gle/iayxioqf1eaju5De7\">here</a>\r\n" + //
                "   <p>byeeeeeeeeeeeeeeeeeee</p>\r\n" + //
                "  </div>\r\n" + //
                "</body>\r\n" + //
                "</html>";
        File f = new File("C:\\hotel_reservation_submission\\testX.html");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            bw.write(html);
            bw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}

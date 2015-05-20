package mee;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  public static void main(String[] argv) throws Exception {

    Pattern pattern = Pattern.compile("pattern");
    FileInputStream input = new FileInputStream("c:\file.txt");
    FileChannel channel = input.getChannel();

 

    ByteBuffer bbuf = channel.map(FileChannel.MapMode.READ_ONLY, 0, (int) channel.size());
  CharBuffer cbuf = Charset.forName("8859_1").newDecoder().decode(bbuf);

    Matcher matcher = pattern.matcher(cbuf);

    while (matcher.find()) {

 

String match = matcher.group();

 

System.out.println(match);

    }

  }

}




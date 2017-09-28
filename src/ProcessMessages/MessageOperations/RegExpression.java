package ProcessMessages.MessageOperations;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpression
{

    public static boolean match(String pattern, String msg)
    {
        Pattern pattern1 = Pattern.compile(pattern);
        Matcher matcher = pattern1.matcher(msg);
        if(matcher.find())
            return true;
        else
            return false;

    }

    public static List<String> getToken(String type, String msg)
    {
        Matcher m1 = getMatch(type,msg);
        int count = m1.groupCount();
        List<String> record = new ArrayList<String>();
        for( int i=0; i<= count;i++)
          record.add(m1.group(i));

        return record;
    }

    private static Matcher getMatch(String type, String msg)
    {
      Pattern pat = Pattern.compile(type);
        Matcher match1 = pat.matcher(msg);
        if(match1.find())
            return match1;
        else
            return null;
    }
}

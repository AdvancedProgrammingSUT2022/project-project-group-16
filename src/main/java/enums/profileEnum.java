package enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum profileEnum
{
    //commands
    changeNickname("^\\s*profile\\s+change\\s+--nickname\\s+(?<newNickname>\\S+)$"),
    changePassword("^\\s*profile\\s+change\\s+--password\\s+--current\\s+(?<currentPassword>.+)\\s+--new\\s+(?<newPassword>.+)\\s*$"),

    //messages
    successfulPassChange("password changed successfully!"),
    successfulNicknameChange("nickname changed successfully!"),
    invalidOldPass("current password is invalid"),
    commonPasswords("please enter a new password"),
    currentMenu("Profile Menu");

    public final String regex;

    profileEnum(String regex)
    {
        this.regex = regex;
    }

    public static Matcher compareRegex(String command, profileEnum regex)
    {
        Matcher matcher = Pattern.compile(regex.regex).matcher(command);
        if(matcher.matches())
            return matcher;
        return null;
    }
}
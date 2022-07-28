package cn.gzsxy.oop.features.compose;
/*
演示组合
 */
public class TestCompose03 {
    public static void main(String[] args) {
        LogMailService mail = new LogMailService(new DefaultMailService());
        String s = mail.sendMail("120");
        System.out.println(s);

    }
}

class LogMailService{
    private MailService mailService;
    public LogMailService(MailService mailService){
        this.mailService = mailService;
    }
    public String sendMail(String msg){
        long l = System.nanoTime();
        String m = mailService.send(msg);
        long e = System.nanoTime();
        System.out.println("发送邮件用时"+(e - l)+"秒");
        return m;
    }
}

interface MailService{
    String send(String msg);
}
final class DefaultMailService implements MailService{
    @Override
    public String send(String msg) {
        System.out.println("我发送了一条邮件");
        return msg;
    }
}

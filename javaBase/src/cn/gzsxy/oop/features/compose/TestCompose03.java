package cn.gzsxy.oop.features.compose;
/*
演示组合
 */
public class TestCompose03 {
    public static void main(String[] args) {
        LogMailService o = new LogMailService(new DefaulMailService());
        o.addMail("kkk");
    }
}

class LogMailService{
    private MailService mail;
    public LogMailService(MailService mail){
        this.mail = mail;
    }
    public String addMail(String msg){
        long l = System.nanoTime();
        mail.send(msg);
        long e = System.nanoTime();
        System.out.println("发送邮件用时"+(e - l)+"秒");
        return msg;
    }
}
interface MailService{
    String send(String msg);
}

final class DefaulMailService implements MailService{
    @Override
    public String send(String msg) {
        System.out.println("我发送一份邮件了");
        return msg;
    }
}

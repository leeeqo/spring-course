package IoC_DI;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMyConfig {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        //Person person = context.getBean("personBean", Person.class);
        //person.callYourPet();

        //Pet cat = context.getBean("catBean", Pet.class);
        //cat.say();

        Person person = context.getBean("personBean", Person.class);
        person.callYourPet();
        System.out.println(person.getSurname());
        System.out.println(person.getAge());

        context.close();
    }
}

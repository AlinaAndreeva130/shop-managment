package ru.andreeva.shop.ui.view.entity;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import ru.andreeva.shop.ui.view.MainLayout;

@Route(value = "users", layout = MainLayout.class)
@PageTitle("Читатели")
@Tag("user-view")
@JsModule("./view/entity/user-view.ts")
@UIScope
// @Component
public class UserView /*extends BaseView<User, Integer, UsersRepository>*/ {

   /* public UserView(UserSpecificationFactoryImpl specificationFactory, UsersRepository usersRepository,
                    UserEditor editor) {
        super(usersRepository, specificationFactory, editor);
    }*/

    /*@Override
    protected void createColumns() {
        grid.addColumn(User::getFirstName).setHeader("Фамилия").setKey("firstName");
        grid.addColumn(User::getLastName).setHeader("Имя").setKey("lastName");
        grid.addColumn(User::getPatronymic).setHeader("Отчество").setKey("patronymic");
        grid.addColumn(User::getAddress).setHeader("Адрес").setKey("address");
    }*/
}

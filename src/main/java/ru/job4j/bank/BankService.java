package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывающий модель работы банковковской системы
 * в системе можно производить следующие действия:
 * 1. Регистрировать пользователя.
 * 2. Удалять пользователя из системы.
 * 3. Добавлять пользователю банковский счет.
 * У пользователя системы могут быть несколько счетов.
 * 4. Переводить деньги с одного банковского счета на другой счет.
 * @author Konstantin Zamaraev
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение счетов пользователя осуществляется в коллекции типа ArrayList
     * Хранение пользователей и связь со счетами осуществляется в коллекции типа HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя в систему если его еще нет в системе
     * принимает один параметр пользователя, а также добавляет к нему пустой список по умолчаниию.
     * @param user параметр пользователя добавляемый в систему
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод добавляет пользователя из системы по номеру паспорта
     * @param passport номер паспорта удаляемого пользователя
     * @return возвращает true если удаление прошло успешно и false если пользователь не найден.
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;
    }

    /**
     * Метод добавляет новый счет к пользователю
     * @param passport номер паспорта пользователя
     * @param account добавляемый счет
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            if (!users.get(user).contains(account)) {
                users.get(user).add(account);
            }
        }
    }

    /**
     * Метод осуществляет поиск пользователя по номеру паспорта
     * @param passport номер паспорта пользователя
     * @return возвращает найденного пользователя или null если его не существует
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(s -> s.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод осуществляет поиск счета пользователя по реквизитам
     * @param passport номер паспорта пользователя
     * @param requisite счет пользователя
     * @return возвращает найденный счет пользователя или null если его не существует
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return getAccounts(user)
                    .stream()
                    .filter(s -> s.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод осуществляет перевод денег с одного счета на другой
     * @param srcPassport номер паспорта пользователя со счета которого переводят
     * @param srcRequisite счет пользователя с которого переодят
     * @param destPassport номер паспорта пользователя на счет которому переводят
     * @param destRequisite счет пользователя на который перводят
     * @param amount сумма перевода
     * @return возвращает true если перевод прошел успешно
     * и false если пользователь не найден или недостаточно денег на счете.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srs = findByRequisite(srcPassport, srcRequisite);
        Account dest = findByRequisite(destPassport, destRequisite);
        if (srs != null && dest != null && srs.getBalance() >= amount) {
            srs.setBalance(srs.getBalance() - amount);
            dest.setBalance(dest.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    /**
     * Метод возвращает список счетов пользователя
     * @param user пользователь
     * @return возвращает список счетов
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}

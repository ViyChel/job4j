package ru.job4j.bank;

import java.util.*;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void removeUser(User user) {
        if (this.users.containsKey(user)) {
            users.remove(user);
            System.out.println("The user has been deleted");
        } else {
            System.out.println("This user does not exist!");
        }
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            if (this.users.get(user).contains(account)) {
                System.out.println("Account already exists!");
            } else {
                this.users.get(user).add(account);
            }
        } else {
            System.out.println("This user does not exist!");
        }
    }

    public User findByPassport(String passport) {
        User rsl = null;
        for (User user : this.users.keySet()) {
            if (user.getPassport().equals(passport)) {
                rsl = user;
                break;
            }
        }
        return rsl;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account : this.users.get(user)) {
                if (account.getRequisite().equals(requisite)) {
                    rsl = account;
                }
            }
        } else {
            System.out.println("This user does not exist!");
        }
        return rsl;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        User userSrc = findByPassport(srcPassport);
        User userDest = findByPassport(destPassport);
        boolean accountSrc = this.users.get(userSrc).contains(findByRequisite(srcPassport, srcRequisite));
        boolean accountDest = this.users.get(userDest).contains(findByRequisite(destPassport, destRequisite));
        if (accountSrc && accountDest && findByRequisite(srcPassport, srcRequisite).getBalance() >= amount) {
            findByRequisite(srcPassport, srcRequisite).setBalance(findByRequisite(srcPassport, srcRequisite).getBalance() - amount);
            findByRequisite(destPassport, destRequisite).setBalance(findByRequisite(destPassport, destRequisite).getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
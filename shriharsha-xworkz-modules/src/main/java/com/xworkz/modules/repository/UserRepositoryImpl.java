package com.xworkz.modules.repository;

import com.xworkz.modules.entity.LoginEntity;
import com.xworkz.modules.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Repository
public class UserRepositoryImpl implements UserRepository{

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    public boolean save(UserEntity userEntity) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(userEntity);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public UserEntity findByMail(String mail) {
        EntityManager entityManager= null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            Query query = entityManager.createNamedQuery("findByEmail");
            query.setParameter("email", mail);
            return (UserEntity) query.getSingleResult();
        }
        catch (  NoResultException e){
            e.printStackTrace();
            return null;
        }
        finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public UserEntity findByNumber(String number) {
        EntityManager entityManager= null;
        EntityTransaction transaction= null;
        try {
            entityManager = entityManagerFactory.createEntityManager();

            Query query = entityManager.createNamedQuery("findByNumber");
            query.setParameter("phoneNumber",number);
            return (UserEntity) query.getSingleResult();
        }
        catch (  NoResultException e){
            e.printStackTrace();
            return null;
        }
        finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public boolean saveLoginInfo(LoginEntity loginEntity) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            entityManager.persist(loginEntity);

            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public boolean updateUser(UserEntity entity) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.merge(entity);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }
}

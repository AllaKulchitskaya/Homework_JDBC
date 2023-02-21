package dao.impl;

import configuration.HibernateSessionFactoryUtil;
import dao.CityDAO;
import entity.City;
import entity.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class CityDAOImpl implements CityDAO {
    @Override
    public void createCity(City city) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(city);
            transaction.commit();
        }
    }

    @Override
    public City getCityById(int cityId) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.get(City.class, cityId);
        }
    }

    @Override
    public List<City> getAllCities() {
        List<City> cities;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            cities = new ArrayList<>(session.createQuery("FROM City", City.class).list());
        }
        return cities;
    }

    @Override
    public void updateCity(City city) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.update(city);
            transaction.commit();
        }
    }

    @Override
    public void deleteCity(City city) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(city);
            transaction.commit();
        }
    }
}

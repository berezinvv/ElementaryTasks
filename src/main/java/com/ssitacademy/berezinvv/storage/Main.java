package com.ssitacademy.berezinvv.storage;

import com.ssitacademy.berezinvv.storage.dao.binary.BinaryCRUD;
import com.ssitacademy.berezinvv.storage.dao.db.service.CarService;
import com.ssitacademy.berezinvv.storage.dao.json.JsonCRUD;
import com.ssitacademy.berezinvv.storage.dao.ram.RamCRUD;
import com.ssitacademy.berezinvv.storage.dao.xml.XmlCRUD;
import com.ssitacademy.berezinvv.storage.model.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        {
            Engine engineFisrt = new Engine(1, "1.4", Fuel.A95);
            Engine engineSecond = new Engine(2, "1.6", Fuel.DIESEL);
            Engine engineThird = new Engine(3, "2.0", Fuel.DIESEL);
            Owner ownerFirst = new Owner(1, "Matt", "Grass");
            Owner ownerSecond = new Owner(2, "Alice", "Pound");


            Car carToyota = new Car(1, "Toyota", "Corolla", engineFisrt, ownerFirst);
            Car carRenault = new Car(2, "Renault", "Duster", engineSecond, ownerSecond);
            Car carSkoda = new Car(3, "Skoda", "Octavia", engineThird, ownerSecond);


            //json
            System.out.println("-------------------json-------------------");
            System.out.println("---Car--");
            JsonCRUD carJsonCRUDService = new JsonCRUD<Car>(Car.class);
            List<Car> carsJson = carJsonCRUDService.getAll();

            for (Car car : carsJson) {
                System.out.println(car);
            }
            System.out.println("---Engine--");
            JsonCRUD engineJsonCRUDService = new JsonCRUD<Engine>(Engine.class);
            List<Engine> listEngine = engineJsonCRUDService.getAll();
            for (Engine engine : listEngine) {
                System.out.println(engine);
            }

            //RAM
            System.out.println("-------------------RAM-------------------");
            RamCRUD carRamCRUDService = new RamCRUD<Car>(Car.class);
            carRamCRUDService.save(carSkoda);
            carRamCRUDService.save(carToyota);

            List<Car> carsRam = carRamCRUDService.getAll();
            for (Car car : carsRam) {
                System.out.println(car);
            }

            System.out.println("---Update---");
            Car carUpdate = (Car) carRamCRUDService.getById(1);
            carUpdate.setOwner(ownerSecond);
            carRamCRUDService.update(carUpdate);

            carsRam = carRamCRUDService.getAll();

            for (Car car : carsRam) {
                System.out.println(car);
            }

            //Binary
            System.out.println("-------------------Binary-------------------");
            BinaryCRUD binaryCRUDServise = new BinaryCRUD<Car>(Car.class);
            binaryCRUDServise.save(carRenault);
            binaryCRUDServise.save(carToyota);

            List<Car> carsBinary = binaryCRUDServise.getAll();
            for (Car car : carsBinary) {
                System.out.println(car);
            }

            System.out.println("---Update---");
            Car carUpdateB = (Car) binaryCRUDServise.getById(1);
            carUpdateB.setOwner(ownerFirst);
            carUpdateB.setEngine(engineThird);
            binaryCRUDServise.update(carUpdateB);

            carsBinary = binaryCRUDServise.getAll();
            for (Car car : carsBinary) {
                System.out.println(car);
            }
            //xml
            System.out.println("-------------------xml-------------------");
            XmlCRUD xmlServiceDAO = new XmlCRUD(Car.class);
            xmlServiceDAO.save(carRenault);
            xmlServiceDAO.save(carToyota);

            List<Car> cars = xmlServiceDAO.getAll();
            for (Car car: cars) {
                System.out.println(car);
            }

            System.out.println("---Update---");
            Car carUpdateX = (Car) xmlServiceDAO.getById(1);
            carUpdateX.setOwner(ownerFirst);
            carUpdateX.setEngine(engineThird);
            xmlServiceDAO.update(carUpdateX);

            cars = xmlServiceDAO.getAll();
            for (Car car: cars) {
                System.out.println(car);
            }
            //DB
            System.out.println("-------------------DB-------------------");

            CarService dbStorageCRUD = new CarService();
            dbStorageCRUD.delete(carSkoda);

            System.out.println("---getAll---");
            List<Car> carsDB = dbStorageCRUD.getAll();
            for (Car car : carsDB) {
                System.out.println(car);
            }

            System.out.println("---getById(1)---");
            Car carUpdateDB = dbStorageCRUD.getById(1);
            System.out.println(carUpdateDB);

            System.out.println("---Add---");
            List<NoteMaintenance> noteMaintenanceList = new ArrayList<NoteMaintenance>();
            noteMaintenanceList.add(new NoteMaintenance(4, carSkoda, 2000.0, ""));

            carSkoda.setNoteMaintenanceList(noteMaintenanceList);

            dbStorageCRUD.save(carSkoda);

            Car carLexus = new Car(4, "Lexus", "450", engineSecond, ownerSecond);
            carLexus.setNoteMaintenanceList(noteMaintenanceList);
            dbStorageCRUD.save(carLexus);

            carsDB = dbStorageCRUD.getAll();
            for (Car car : carsDB) {
                System.out.println(car);
            }

            System.out.println("---Delete---");
            dbStorageCRUD.delete(carLexus);

            carsDB = dbStorageCRUD.getAll();
            for (Car car : carsDB) {
                System.out.println(car);
            }
        }
    }
}

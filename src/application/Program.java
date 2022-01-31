package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrasilTaxService;
import model.services.RentalService;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

        Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");
		
	System.out.println("BEM VINDO AO PROGRAMA TESTE/RENTAL");
	
	System.out.println();
		
	System.out.println("Entre com os dados da locação");
	System.out.print("Modelo do carro: ");
	String carModel = sc.nextLine();
	System.out.println("Saida (dd/MM/yyyy hh:ss): ");
	Date start = sdf.parse(sc.nextLine());	
	System.out.print("Retorno (dd/MM/yyyy hh:ss): ");
	Date finish = sdf.parse(sc.nextLine());
	
	CarRental car = new CarRental(start, finish, new Vehicle(carModel));
	
	System.out.print("Preço por hora: ");
	double pricePerHour = sc.nextDouble();
	System.out.print("Preço por Dia: ");
	double pricePerDay = sc.nextDouble();
		
		RentalService rentalService = new RentalService(pricePerDay, pricePerHour,new BrasilTaxService());
		
		rentalService.processInvoice(car);
		
	System.out.println("Dados: ");
	
	System.out.println("Valor Base: " + String.format("%.2f", car.getInvoice().getBasicPayment()));
	System.out.println("Taxa: " + String.format("%.2f", car.getInvoice().getTax()));
	System.out.println("Total: "+ String.format("%.2f", car.getInvoice().getTotalPayment()));	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
					sc.close();
				}
		
	}


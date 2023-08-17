//
//  AgregarDeudaScreen.swift
//  ControlGastos
//
//  Created by Joel on 17/08/23.
//

import SwiftUI

struct AgregarDeudaScreen: View {
    @State private var paymentMethod = 0
    @State private var isDeuda = 0
    
    @EnvironmentObject var viewModel: AgregarDeudaViewModel
    
    
    var body: some View {
        Form {
            Section(header: Text("Detalles de Pago")) {
                TextField("Ingresar monto", text: $viewModel.monto)
                TextField("Ingresar descripción", text: $viewModel.descrip)
            }
            
            Section(header: Text("Método de Pago")) {
                HStack{
                    Button(action: {
                        paymentMethod = 1
                    }){
                        CardView(iconName: "dollarsign", title: "Efectivo")
                        .background((paymentMethod == 1) ? Color.blue : Color.white)
                    }
                    Button(action: {
                        paymentMethod = 2
                    }){
                        CardView(iconName: "creditcard.fill", title: "Tarjeta")
                            .background((paymentMethod == 2) ? Color.green : Color.white)
                    }
                }
                
                
                Picker("Método", selection: $isDeuda) {
                    Text("Gasto").tag(0)
                    Text("Ingreso").tag(1)
                }
                .pickerStyle(SegmentedPickerStyle())
            }
            
            Button("Aceptar") {
                viewModel.insert()
            }
            .buttonStyle(.bordered)
        }
        .navigationBarTitle("Agregar Movimiento", displayMode: .inline)
    }
}

struct CardView: View {
    var iconName: String
    var title: String
    var body: some View {
        VStack {
            Image(systemName: iconName)
                .font(.largeTitle)
            Text(title)
                .font(.headline)
        }
        .padding()
        .cornerRadius(10)
        .shadow(radius: 4)
    }
}

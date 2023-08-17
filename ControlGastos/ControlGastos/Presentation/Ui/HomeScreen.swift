//
//  HomeScreen.swift
//  ControlGastos
//
//  Created by Joel on 17/08/23.
//

import SwiftUI

struct HomeScreen: View {
    @State private var newItemName = ""
    @EnvironmentObject var viewModel: HomeViewModel
    
    var body: some View {
        NavigationView {
            List {
                ForEach(viewModel.items) { item in
                    HStack{
                        
                        Text(item.descrip ?? "")
                        Spacer(minLength: 20)
                        let monto = String(item.monto)
                        Text(monto)
                            
                    }.contextMenu {
                        Button("Eliminar") {
                            viewModel.deleteItem(item: item)
                        }
                    }
                }
                .onDelete { indexSet in
                    viewModel.deleteItems(at: indexSet)
                }
            }
            .navigationBarTitle("Lista de Items")
            .navigationBarItems(
                trailing:
                    NavigationLink(destination: AgregarDeudaScreen()){
                        Image(systemName: "plus.circle.fill")
                    }
            )
        }
    }
}

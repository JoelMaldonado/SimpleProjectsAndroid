//
//  HomeViewModel.swift
//  ControlGastos
//
//  Created by Joel on 17/08/23.
//

import Foundation

class HomeViewModel: ObservableObject {
    
    @Published var items: [Deuda] = []
    private let useCase: DeudaUseCaseProtocol
    
    init(useCase: DeudaUseCaseProtocol) {
        self.useCase = useCase
        listarDeudas()
    }
    
    func listarDeudas() {
        items = useCase.tasks
    }
    
    
    func deleteItems(at offsets: IndexSet) {
        for index in offsets {
            let item = items[index]
            useCase.delete(deuda: item)
        }
        PersistenceController.shared.saveContext()
        listarDeudas()
    }
    
    func deleteItem(item: Deuda) {
        useCase.delete(deuda: item)
        listarDeudas()
    }
}

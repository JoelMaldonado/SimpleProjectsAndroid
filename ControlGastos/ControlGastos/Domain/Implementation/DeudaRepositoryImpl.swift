//
//  DeudaRepositoryImpl.swift
//  ControlGastos
//
//  Created by Joel on 17/08/23.
//

import Foundation

final class DeudaRepositoryImpl: DeudaRepository {
    
    private let context = PersistenceController.shared.container.viewContext
    
    func listarPruebas() -> [Deuda] {
        var list : [Deuda] = []
        do {
            list = try context.fetch(Deuda.fetchRequest())
        }catch{
            print("Error loading items: \(error)")
        }
        return list
    }
    
    func insert(deuda: Deuda) {
        let newItem = Deuda(context: context)
        newItem.descrip = deuda.descrip
        newItem.metodo = deuda.metodo
        newItem.monto = deuda.monto
        PersistenceController.shared.saveContext()
    }
    
    func delete(deuda: Deuda) {
        context.delete(deuda)
        PersistenceController.shared.saveContext()
    }
    
    
}

//
//  DeudaUsecase.swift
//  ControlGastos
//
//  Created by Joel on 17/08/23.
//

import Foundation

protocol DeudaUseCaseProtocol {
    var tasks: [Deuda] { get }
    func insert(deuda: Deuda)
    func delete(deuda: Deuda)
}

final class DeudaUseCase: DeudaUseCaseProtocol {
    private let repository: DeudaRepository
    
    init(repository: DeudaRepository) {
        self.repository = repository
    }
    
    var tasks: [Deuda] {
        repository.listarPruebas()
    }
    
    func insert(deuda: Deuda) {
        repository.insert(deuda: deuda)
    }
    
    func delete(deuda: Deuda) {
        repository.delete(deuda: deuda)
    }
    
}

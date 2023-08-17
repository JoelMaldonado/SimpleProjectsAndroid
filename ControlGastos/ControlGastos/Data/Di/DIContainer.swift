//
//  DIContainer.swift
//  ControlGastos
//
//  Created by Joel on 17/08/23.
//

import Swinject
final class DIContainer {
    static let shared = DIContainer()
    
    private let container = Container()
    
    init() {
        setupDependencies()
    }
    
    private func setupDependencies() {
        container.register(DeudaRepository.self) { _ in
            DeudaRepositoryImpl()
        }
        
        container.register(DeudaUseCaseProtocol.self) { resolver in
            let repository = resolver.resolve(DeudaRepository.self)!
            return DeudaUseCase(repository: repository)
        }
        
        container.register(HomeViewModel.self) { resolver in
            let useCase = resolver.resolve(DeudaUseCaseProtocol.self)!
            return HomeViewModel(useCase: useCase)
        }
        container.register(AgregarDeudaViewModel.self) { resolver in
            let useCase = resolver.resolve(DeudaUseCaseProtocol.self)!
            return AgregarDeudaViewModel(useCase: useCase)
        }
    }
    
    func resolve<T>(_ type: T.Type) -> T {
        container.resolve(type)!
    }
}

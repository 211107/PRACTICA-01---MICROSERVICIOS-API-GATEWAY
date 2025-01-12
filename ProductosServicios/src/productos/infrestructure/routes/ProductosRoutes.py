from flask import Blueprint, request
from src.productos.infrestructure.controllers.productoscontrollers.GetController import GetController
from src.productos.infrestructure.controllers.productoscontrollers.DeleteController import DeleteController
from src.productos.infrestructure.controllers.productoscontrollers.CreateController import CreateController
from src.productos.infrestructure.repositories.mysqlrepositories.ProductosRepository import ProductosRepository

product_routes = Blueprint('product_routes', __name__)

repo = ProductosRepository()
get_controller = GetController(repo)
delete_controller = DeleteController(repo)
create_controller = CreateController(repo)

@product_routes.route("/", methods=["GET"])
def get():
    return get_controller.run()

@product_routes.route("/", methods=["POST"])
def create():
    return create_controller.run(request)

@product_routes.route("/<string:id>", methods=["DELETE"])
def delete(id):
    return delete_controller.run(id)

INSERT INTO `usuarios` VALUES (10,NULL,NULL,NULL,NULL,'Soporte','generico3@gmail.com',false,'Kiosco','$2a$10$QPJSZV.XAzPd1p/M0rqzPeOJRbaznP.uqej1vO0ukZ/6XKHuDS43u','kiosco'),(16,NULL,NULL,NULL,NULL,'areiza','dirielfran@gmail.com',true,'Elvis','$2a$10$QPJSZV.XAzPd1p/M0rqzPeOJRbaznP.uqej1vO0ukZ/6XKHuDS43u','eareiza');
INSERT INTO `roles` VALUES (2,'ROLE_ADMIN'),(3,'ROLE_COORDINATOR'),(1,'ROLE_USER');
INSERT INTO `usuarios_roles` VALUES (10,1),(16,1),(10,2),(16,2),(10,3),(16,3);

-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.1.16-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win32
-- HeidiSQL Versión:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura de base de datos para agenda
CREATE DATABASE IF NOT EXISTS `agenda` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci */;
USE `agenda`;


-- Volcando estructura para tabla agenda.agenda
CREATE TABLE IF NOT EXISTS `agenda` (
  `nom` varchar(50) COLLATE utf8_spanish_ci NOT NULL COMMENT 'Nombre',
  `ci` varchar(50) COLLATE utf8_spanish_ci NOT NULL COMMENT 'Cedula',
  `tel` varchar(50) COLLATE utf8_spanish_ci NOT NULL COMMENT 'Teléfono',
  PRIMARY KEY (`ci`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- Volcando datos para la tabla agenda.agenda: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `agenda` DISABLE KEYS */;
INSERT INTO `agenda` (`nom`, `ci`, `tel`) VALUES
	('Eugenio', '1111', '095036103'),
	('Diego', '1234567', '1235478'),
	('Elbio', '2222', '09854103'),
	('María Eugenia', '47088942', '24017951');
/*!40000 ALTER TABLE `agenda` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
agendaagenda